До:
```java
    public List<PurchaseElk> processListPurchaseElk(ExecutionContext ctx, ListPurchasedElkParamSet params) {

        ServiceAccountDao serviceAccountDao = new ServiceAccountDbDao(ctx.getSession());
        long serviceAccountId = serviceAccountDao.getIdByAccountNumber(params.getServiceAccountNumber());

        // Получаем покупки и оставляем в списке только покупки с положительной ценой и wsResult = 1, 
        // а также сбрасываем дату окончания срока действия для EST-покупок
        List<PurchaseElk> purchases = service.findPurshasedElk(ctx, serviceAccountId, params.getFromDate(), params.getToDate());
        
        for (int i = 0; i < purchases.size(); i++) {
            PurchaseElk purchase = purchases.get(i);
            
            if(!"1".equals(purchase.getWsResult())) {
                purchases.remove(i);
                break;
            }
            
            try {
                long price = Long.parseLong(purchase.getPrice());
                if (price <= 0) {
                    purchases.remove(i);
                    break;
                }
            } catch (Exception e) {
                log.debug("Can not parse string <{}> as long", purchase.getPrice(), e);
                purchases.remove(i);
                break;
            }
            
            if ("ESTPURCHASE".equals(purchase.getServiceSpecDiscriminator())
                || "ESTCONTENTPURCHASE".equals(purchase.getServiceSpecDiscriminator())) {
                purchase.setStopDate(null);
            }
        }
        
        return purchases;
    }
```

После:
```java
    @Override
    public List<PurchaseElk> processListPurchaseElk(ExecutionContext ctx, ListPurchasedElkParamSet params) {

        ServiceAccountDao serviceAccountDao = new ServiceAccountDbDao(ctx.getSession());
        long serviceAccountId = serviceAccountDao.getIdByAccountNumber(params.getServiceAccountNumber());

        // Получаем покупки и оставляем в списке только покупки с положительной ценой и wsResult = 1, 
        // а также сбрасываем дату окончания срока действия для EST-покупок
        return service
                .findPurshasedElk(ctx, serviceAccountId, params.getFromDate(), params.getToDate()).stream()
                .filter(p -> "1".equals(p.getWsResult()))
                .filter(p -> toLongDefaultZero(p.getPrice()) > 0)
                .map(this::getPurchaseWithNullStopDateForEst)
                .collect(Collectors.toList());
    }

    private long toLongDefaultZero(String stringValue) {
        long result;
        try {
            result = Long.parseLong(stringValue);
        } catch (Exception e) {
            log.debug("Can not parse string <{}> as long", stringValue, e);
            result = 0;
        }
        return result;
    }
    
    private PurchaseElk getPurchaseWithNullStopDateForEst(PurchaseElk p) {
        if ("ESTPURCHASE".equals(p.getServiceSpecDiscriminator())
            || "ESTCONTENTPURCHASE".equals(p.getServiceSpecDiscriminator())) {
            p.setStopDate(null);
        }
        return p;
    }
```