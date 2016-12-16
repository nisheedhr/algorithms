package com.graph;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class ExprDivisionTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testCalcEquation() throws Exception {
    String[][] equations = { { "a", "b" }, { "b", "c" } };
    double[] values = { 2.0, 3.0 };
    String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
    System.out.println(Arrays.toString(new ExprDivision().calcEquation(equations, values, queries)));
  }

}
