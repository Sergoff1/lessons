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
        LinkedList<Integer> adjacencyVertex = new LinkedList<>();
        
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
            adjacencyVertex.add(i);
          }
        }

        // Среди смежных вершин целевой нет
        for (Integer i : adjacencyVertex)
        {
          if (!vertex[i].Hit) 
          {
            currentVertex = i;
            stack.push(currentVertex);
            break;
          }

          // Все смежные вершины текущего узла проверены
          if (i == adjacencyVertex.getLast())
          {
            stack.pop();
            if (!stack.isEmpty()) currentVertex = stack.peek();
          }
        }
      }
      return path;
    }


    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo)
    {
      // Узлы задаются позициями в списке vertex.
      // Возвращается список узлов -- путь из VFrom в VTo.
      // Список пустой, если пути нет.
      for (Vertex i : vertex) i.Hit = false;
      ArrayList<Vertex> path = new ArrayList<>();
      Queue<Integer> queue = new LinkedList<>();
      int currentVertex = VFrom;
      vertex[currentVertex].Hit = true;
      int[] prevVertex = new int[max_vertex];
      while (true)
      {
        LinkedList<Integer> unvisitedVertex = new LinkedList<>();
        
        for (int i = 0; i < max_vertex; i++)
        {

          if (m_adjacency[currentVertex][i] == 1 && !vertex[i].Hit)
          {
            if (i == VTo)
            {
              prevVertex[VTo] = currentVertex;
              int v = VTo;
              while (v != VFrom)
              {
                path.add(vertex[v]);
                v = prevVertex[v];
              }
              path.add(vertex[VFrom]);
              Collections.reverse(path);
              return path;
            }
            unvisitedVertex.add(i);
          }
        }

        if (unvisitedVertex.size() != 0)
        {
          prevVertex[unvisitedVertex.peekFirst()] = currentVertex;
          vertex[unvisitedVertex.peekFirst()].Hit = true;
          queue.add(unvisitedVertex.getFirst());
        } else if (!queue.isEmpty())
        {
          currentVertex = queue.remove();
        } else break;
      }

      return path;
    }

    public ArrayList<Vertex> WeakVertices()
    {
      // возвращает список узлов вне треугольников
      ArrayList<Vertex> weakVert = new ArrayList<>();
      for (int i = 0; i < max_vertex; i++)
      {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int j = 0; j < max_vertex; j++)
        {
          if (i != j && m_adjacency[i][j] == 1)
          {
            neighbors.add(j);
          }
        }

        boolean isStrongVertex = false;
        for (int k = 0; k < neighbors.size(); k++)
        {
          for (int c = k; c < neighbors.size(); c++)
          {
            if (k!=c && m_adjacency[neighbors.get(k)][neighbors.get(c)] == 1)
            {
              isStrongVertex = true;
              break;
            }
          }
          if (isStrongVertex) break;
        }

        if (!isStrongVertex && vertex[i] != null)
          {
            weakVert.add(vertex[i]);
          }

      }
      return weakVert;
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