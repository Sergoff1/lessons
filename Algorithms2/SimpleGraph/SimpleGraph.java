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
}

class Vertex
{
    public int Value;
    public Vertex(int val)
    {
      Value = val;
    }

    @Override
    public String toString() {
    return Value+"";
    }
}