package nlcs;
import java.util.*;

class bellman
{
  public static void bell(int graph[][],int V,int E,int src)
  {
    int []distance=new int[V];
    //Initializing the distance to 1 for all the vertices
    for(int i=1;i<V;i++)
      distance[i]=Integer.MAX_VALUE;
    //Relaxing all the edges V-1 times
    for(int i=0;i<V;i++)
    {
      for(int j=0;j<E;j++)
      {      //dist(v)+cost(u,v)<dist(v)
        if(distance[graph[j][0]]+graph[j][2]<distance[graph[j][1]])
        {
          distance[graph[j][1]]=distance[graph[j][0]]+graph[j][2];
        }
      }
    }
    //Checking for negative weight cycle
    for(int i=0;i<E;i++)
    {
      int start=graph[i][0];
      int desti=graph[i][1];
      int cost=graph[i][2];
      if(distance[start]!=Integer.MAX_VALUE && distance[start]+cost<distance[desti])
        System.out.println("Negative weight cycle detected");
    }
    for(int i=0;i<V;i++)
    {
      System.out.println("Shortest distance from 0 to:"+i+" is "+distance[i]);
    }
    
  }
  public static void main(String args[])
  {
    int V=5;
    int E=7;
    int graph[][]={{0,1,2},{0,3,1},{0,2,6},
    {1,3,3},{1,4,6},
    {2,4,1},
    {3,4,5}};
    bell(graph,V,E,0);
  } 
}