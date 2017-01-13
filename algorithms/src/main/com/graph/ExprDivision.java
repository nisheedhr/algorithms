package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 *  and k is a real number (floating point number). Given some queries, return the answers. 
 *  If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 where equations.size() == values.size(), and the values are positive. This represents the equations.
  Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero 
and there is no contradiction.
 * @author nraveend
 *
 */
public class ExprDivision {

  private static class Expr {
    Expr(double val, String var) {
      this.val = val;
      this.var = var;
    }
    
    double val;
    String var;
    double curTotal;
  }
  
  /**
   * Key idea is to use BFS graph traversal to compute value.
   * If no path return -1.
   * @param equations
   * @param values
   * @param queries
   * @return
   */
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
  
    Map<String, List<Expr>> exprMap = new HashMap<>();
    
    int i = 0;
    for (String[] exp: equations) {
      parseExpression(exp, values[i++], exprMap);
    }
    
    double [] result = new double[queries.length];
    
    i = 0;
    for (String[] exp: queries) {
      result[i] = evalExpression(exp,  exprMap);
      i++;
    }
    
    return result;
  }
  
  /**
   * Write code to evaluate the expression
   * @param exp
   * @param exprMap
   * @return
   */
  private double evalExpression(String[] exp, Map<String, List<Expr>> exprMap) {
    Map<Expr, Boolean> visited = new HashMap<>();
    double val = -1;
    Queue<Expr> bfsQueue = new LinkedList<>();
    
    if (exprMap.containsKey(exp[0])) {
      for (Expr adj : exprMap.get(exp[0])) {
        visited.put(adj, true);
        adj.curTotal = 1;
        bfsQueue.offer(adj);
      }
    }
    
    while (!bfsQueue.isEmpty()) {
      Expr cur = bfsQueue.poll();
      if(cur.var.equals(exp[1])) {
        val = cur.curTotal * cur.val;
        break;
      } else {
        for (Expr adj :exprMap.get(cur.var)) {
          if (!visited.containsKey(adj)) {
            visited.put(adj, true);
            adj.curTotal = cur.curTotal * cur.val;
            bfsQueue.offer(adj);
          }
        }
      }
    }
    
    return val;
  }
  /**
   * Add entries in both directions
   * @param exp
   * @param val
   * @param exprMap
   */
  private void parseExpression(String[] exp, double val, Map<String, List<Expr>> exprMap) {
    if (exprMap.containsKey(exp[0])) {
      exprMap.get(exp[0]).add(new Expr(val, exp[1]));
    } else {
      List<Expr> list = new ArrayList<>();
      list.add(new Expr(val, exp[1]));
      exprMap.put(exp[0], list);
    }
    
    if (exprMap.containsKey(exp[1])) {
      exprMap.get(exp[1]).add(new Expr(1 / val, exp[0]));
    } else {
      List<Expr> list = new ArrayList<>();
      list.add(new Expr( 1 / val, exp[0]));
      exprMap.put(exp[1], list);
    }
    
  }
  
}
