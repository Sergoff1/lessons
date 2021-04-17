squirrel - getNumberOfEmeralds (get_number_of_emeralds) // Количество изумрудов добытых белкой (изначально хотел назвать метод getFirstDigitFactorialOf, но название имеет 24 символа и уровень абстрации был бы ниже)

odometer - getTotalDistanceKm (get_total_distance_km) // Метод возвращает общее пройденное расстояние в километрах

ConquestCampaign - getDaysForConquest (get_days_for_conquest) // Получить количество дней для завоевания вражеского государства

MatrixTurn - turn (turn) // Поворот матрицы. Метод меняет переданную ему матрицу. Название объекта не писал,так как он принадлежит классу Matrix

MadMax - getStartingImpulse (get_starting_impulse) // Метод выдаёт стартовый импульс для масимального разгона двигателя

SynchronizingTables - getValidSalaryArray (get_valid_salary_array) // Метод возвращает правильный список зарплат

ShopOLAP - getSalesReport (get_sales_report) // Метод возвращает отчёт о продажах

MassVote - getTheVotingResult (get_the_voting_result) // Метод возвращает результат голосования

Разбил метод BastShoe на 6 методов, чтобы они выполняли ровно одно действие:

BastShoe - addStringTo (add_string_to) // Добавляет строку к текущей

BastShoe - deleteCharsFrom (delete_chars_from) // Удаляет символы из текущей строки

BastShoe - getCharFrom (get_char_from) // Возвращает символ с заданным индексом из текущей строки

BastShoe - undo (undo) // Отменяет операцию изменения текущей строки

BastShoe - redo (redo) // Отменяет undo

BastShoe - selectOperation (select_operation) // Выбирает операцию для применения к текущей строке


PrintingCost - getTonerCosts (get_toner_costs) // Получить расход тонера на печать заданной строки

PatternUnlock - getUnlockSequence (get_unlock_sequence) // Получить последовательность цифр для разблокировки

BigMinus - getDifferenceOfNums (get_difference_of_nums) //Получить разность чисел