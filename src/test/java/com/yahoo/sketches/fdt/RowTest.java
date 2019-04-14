/*
 * Copyright 2019, Yahoo! Inc. Licensed under the terms of the
 * Apache License 2.0. See LICENSE file at the project root for terms.
 */

package com.yahoo.sketches.fdt;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author Lee Rhodes
 */
public class RowTest {
  private static final String LS = System.getProperty("line.separator");

  @Test
  public void checkToString() { //check visually
    Row<String> row = new Row<>("A", 1_000_000, 1E10, 1.2E10, 8E9);
    assertEquals(row.getPrimaryKey(), "A");
    assertEquals(row.getCount(), 1_000_000);
    assertEquals(row.getEstimate(), 1E10);
    assertEquals(row.getUpperBound(), 1.2E10);
    assertEquals(row.getLowerBound(), 8E9);

    println(Row.getRowHeader());
    println(row.toString());
  }

  @Test
  public void printlnTest() {
    println("PRINTING: "+this.getClass().getName());
  }

  /**
   * @param s value to print
   */
  static void println(String s) {
    print(s + LS);
  }

  /**
   * @param s value to print
   */
  static void print(String s) {
    //System.out.print(s);  //disable here
  }

}