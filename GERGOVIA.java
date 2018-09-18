// GERGOVIA - Wine trading in Gergovia
// #greedy
// Gergovia consists of one street, and every inhabitant of the city is a wine salesman. Everyone buys wine from other inhabitants of the city. Every day each inhabitant decides how much wine he wants to buy or sell. Interestingly, demand and supply is always the same, so that each inhabitant gets what he wants.
//
// There is one problem, however: Transporting wine from one house to another results in work. Since all wines are equally good, the inhabitants of Gergovia don't care which persons they are doing trade with, they are only interested in selling or buying a specific amount of wine.
//
// In this problem you are asked to reconstruct the trading during one day in Gergovia. For simplicity we will assume that the houses are built along a straight line with equal distance between adjacent houses. Transporting one bottle of wine from one house to an adjacent house results in one unit of work.
//
// Input
// The input consists of several test cases.
//
// Each test case starts with the number of inhabitants N (2 ≤ N ≤ 100000).
//
// The following line contains n integers ai (-1000 ≤ ai ≤ 1000).
//
// If ai ≥ 0, it means that the inhabitant living in the ith house wants to buy ai bottles of wine. If ai < 0, he wants to sell -ai bottles of wine.
//
// You may assume that the numbers ai sum up to 0.
//
// The last test case is followed by a line containing 0.
//
// Output
// For each test case print the minimum amount of work units needed so that every inhabitant has his demand fulfilled.
//
// Example
// Input:
// 5
// 5 -4 1 -3 1
// 6
// -1000 -1000 -1000 1000 1000 1000
// 0
//
// Output:
// 9
// 9000


import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser sc = new Parser(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            int wine = 0;
            long cost = 0;
            for (int i = 0; i < n; i++) {
                wine += sc.nextInt();
                cost += Math.abs(wine);
            }

            System.out.println(cost);

            n = sc.nextInt();
        }
	}
}
class Parser
{
   final private int BUFFER_SIZE = 1 << 16;

   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;

   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }

   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }

   //reads in the next string
   public String next() throws Exception
   {
      StringBuilder ret =  new StringBuilder();
      byte c = read();
      while (c <= ' ') c = read();
      do
      {
         ret = ret.append((char)c);
         c = read();
      } while (c > ' ');
      return ret.toString();
   }

   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }

   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }

   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
}
