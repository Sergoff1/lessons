public class SimpleGraphTest {
    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(7);

        System.out.println("Список вершин после создания графа: ");
        for (Vertex i : graph.vertex) System.out.print(i+ " ");
        System.out.println();
        System.out.println();

        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);

        System.out.println("Добавляем 7 вершин: ");
        for (Vertex i : graph.vertex) System.out.print(i+ " ");

        System.out.println();
        System.out.println();

        System.out.println("Состояние графа до создания связей: ");
        for (int[] i : graph.m_adjacency)
        {
            for(int j: i)
            {
                System.out.print(j+ " ");
            }            
            System.out.println();
        }  
        System.out.println();

        graph.AddEdge(0, 0);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 0);
        graph.AddEdge(2, 1);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 0);
        graph.AddEdge(3, 1);
        graph.AddEdge(4, 1);
        graph.AddEdge(4, 2);
        graph.AddEdge(1, 5);
        graph.AddEdge(4, 5);
        graph.AddEdge(5, 6);

        System.out.println("Состояние графа после создания связей: ");
        for (int[] i : graph.m_adjacency)
        {
            for(int j: i)
            {
                System.out.print(j+ " ");
            }            
            System.out.println();
        }  
        System.out.println();

        System.out.println("Поиск пути в глубину между вершинами 4 и 7: ");
        System.out.println(graph.DepthFirstSearch(3, 6));
        System.out.println("Поиск пути в ширину между вершинами 4 и 7: ");
        System.out.println(graph.BreadthFirstSearch(3, 6));
        
        System.out.println();

        System.out.println("Поиск пути в глубину между вершинами 4 и 5: ");
        System.out.println(graph.DepthFirstSearch(3, 4));
        System.out.println("Поиск пути в ширину между вершинами 4 и 5: ");
        System.out.println(graph.BreadthFirstSearch(3, 4));
        
        System.out.println();

        System.out.println("Поиск пути между вершинами 0 и 4 после удаления ребра 1-3: ");
        graph.RemoveEdge(0, 2);
        System.out.println(graph.DepthFirstSearch(0, 4));
        System.out.println("Поиск пути в ширину между вершинами 0 и 4 после удаления ребра 1-3: ");
        System.out.println(graph.BreadthFirstSearch(0, 4));
        
        System.out.println();

        System.out.println("Поиск пути между вершинами 0 и 4 после удаления ребра 1-4: ");
        graph.RemoveEdge(0, 3);
        System.out.println(graph.DepthFirstSearch(0, 4));
        System.out.println("Поиск пути в ширину между вершинами 0 и 4 после удаления ребра 1-4: ");
        System.out.println(graph.BreadthFirstSearch(0, 4));
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);

        System.out.println();
 
        graph.RemoveEdge(1, 2);

        System.out.println("Состояние графа после удаления ребра между вершинами 1 и 2: ");
        for (int[] i : graph.m_adjacency)
        {
            for(int j: i)
            {
                System.out.print(j+ " ");
            }            
            System.out.println();
        }  
        System.out.println();

        System.out.println("Список вершин после удаления 0-й вершины: ");
        graph.RemoveVertex(0);
        for (Vertex i : graph.vertex) System.out.print(i+ " ");

        System.out.println();
        System.out.println();
        
        System.out.println("Состояние графа после удаления 0-й вершины: ");
        for (int[] i : graph.m_adjacency)
        {
            for(int j: i)
            {
                System.out.print(j+ " ");
            }            
            System.out.println();
        }  
        System.out.println();

        System.out.println("Между вершинами 2 и 3 есть ребро: " + graph.IsEdge(2, 3));
        
        System.out.println();

        System.out.println("Между вершинами 4 и 2 есть ребро: " + graph.IsEdge(4, 2));

        System.out.println();

        System.out.println("Список вершин сейчас: ");
        for (Vertex i : graph.vertex) System.out.print(i+ " ");

        System.out.println();
        System.out.println();

        System.out.println("Добавим вершину со значением 8: ");
        graph.AddVertex(8);
        for (Vertex i : graph.vertex) System.out.print(i+ " ");

        System.out.println();
        System.out.println();

        System.out.println("Состояние графа после добавления вершины: ");
        for (int[] i : graph.m_adjacency)
        {
            for(int j: i)
            {
                System.out.print(j+ " ");
            }            
            System.out.println();
        }  
        System.out.println();

        graph.AddEdge(0, 0);
        graph.AddEdge(0, 3);

        System.out.println("Состояние графа после добавления пары ребер 0-й вершине: ");
        for (int[] i : graph.m_adjacency)
        {
            for(int j: i)
            {
                System.out.print(j+ " ");
            }            
            System.out.println();
        }  
        System.out.println();

        System.out.println("Между вершинами 0 и 3 есть ребро: " + graph.IsEdge(0, 3));
    }
}
