/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.datasketches.req;

import org.testng.annotations.Test;

/**
 * @author Lee Rhodes
 */
@SuppressWarnings("javadoc")
public class RelativeErrorSketchTest {


  @Test
  public void test1() {
    RelativeErrorQuantiles sk = new RelativeErrorQuantiles(4, true); //w debug
    for (int i = 101; i-- > 1; ) {
      sk.update(i);
    }
    print(sk.getSummary(0));

    for (float i = 10; i <= 100; i += 10) {
      printRank(sk, i + .5f);
    }
  }

  private static void printRank(RelativeErrorQuantiles sk, float v) {
    double r = sk.rank(v);
    println("Normalized Rank: value: " + v + ", rank: " + r);
  }

  @Test
  public void strTest() {
    StringBuilder sb = new StringBuilder();
    float[] arr = {1, 2, 3};
    String fmt = " %.0f";
    for (int i = 0; i < arr.length; i++) {
      String str = String.format(fmt, arr[i]);
      sb.append(str);
    }
    println(sb.toString());
  }


  static final void print(final Object o) { System.out.print(o.toString()); }

  static final void println(final Object o) { System.out.println(o.toString()); }


}
