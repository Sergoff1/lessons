import java.util.*;
  
class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;
	
    public SimpleGraph(int size)
    {
      max_vertex = size;
      m_adjacency = new int [size][size];
      vertex = new Vertex[size];
    }
	
    public void AddVertex(int value)
    {
      // код добавления новой вершины 
      // со значением value 
      // в незанятую позицию vertex
      for (int i = 0; i < vertex.length; i++)
      {
        if(vertex[i] == null)
        {
          vertex[i] = new Vertex(value);
          break;
        }
      }
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v)
    {
      // ваш код удаления вершины со всеми её рёбрами
      vertex[v] = null;
      Arrays.fill(m_adjacency[v], 0);
      for (int i = 0; i < max_vertex; i++)
      {
        m_adjacency[i][v] = 0;
      }
    }
	
    public boolean IsEdge(int v1, int v2)
    {
      // true если есть ребро между вершинами v1 и v2
      return m_adjacency[v1][v2] == 1 && m_adjacency[v2][v1] == 1;
    }
	
    public void AddEdge(int v1, int v2)
    {
      // добавление ребра между вершинами v1 и v2
      m_adjacency[v1][v2] = 1;
      m_adjacency[v2][v1] = 1;
    }
	
    public void RemoveEdge(int v1, int v2)
    {
      // удаление ребра между вершинами v1 и v2
      m_adjacency[v1][v2] = 0;
      m_adjacency[v2][v1] = 0;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo)
    {
      // Узлы задаются позициями в списке vertex.
      // Возвращается список узлов -- путь из VFrom в VTo.
      // Список пустой, если пути нет.
      for (Vertex i : vertex) i.Hit = false;
      ArrayList<Vertex> path = new ArrayList<>();
      Stack<Integer> stack = new Stack<>();
      int currentVertex = VFrom;
      stack.push(currentVertex);
      while (!stack.isEmpty())
      {
        vertex[currentVertex].Hit = true;
        // Cреди смежных узлов есть целевой
        for (int i = 0; i < max_vertex; i++)
        {
          if (m_adjacency[currentVertex][i] == 1)
          {
            if (i == VTo)
            {
              stack.push(VTo);
              for (Integer index : stack) path.add(vertex[index]);
              return path;
            }
          }
        }

        // Среди смежных вершин целевой нет
        for (int i = 0; i < max_vertex; i++)
        {
          if (m_adjacency[currentVertex][i] == 1 && !vertex[i].Hit) 
          {
            currentVertex = i;
            stack.push(currentVertex);
            break;
          }

          // Все смежные вершины текущего узла проверены
          if (i == max_vertex - 1)
          {
            stack.pop();
            if (!stack.isEmpty()) currentVertex = stack.peek();
          }
        }
      }
      return path;
    }
}

class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
      Value = val;
      Hit = false;
    }

    @Override
    public String toString() {
    return Value+"";
    }
}