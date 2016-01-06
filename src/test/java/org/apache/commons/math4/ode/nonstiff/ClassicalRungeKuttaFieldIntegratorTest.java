/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math4.ode.nonstiff;


import org.apache.commons.math4.Field;
import org.apache.commons.math4.RealFieldElement;
import org.apache.commons.math4.util.Decimal64Field;
import org.junit.Test;

public class ClassicalRungeKuttaFieldIntegratorTest extends AbstractRungeKuttaFieldIntegratorTest {

    protected <T extends RealFieldElement<T>> RungeKuttaFieldIntegrator<T>
    createIntegrator(Field<T> field, T step) {
        return new ClassicalRungeKuttaFieldIntegrator<T>(field, step);
    }

    @Test
    public void testNonFieldIntegratorConsistency() {
        doTestNonFieldIntegratorConsistency(Decimal64Field.getInstance());
    }

    @Test
    public void testMissedEndEvent() {
        doTestMissedEndEvent(Decimal64Field.getInstance(), 5.0e-6, 1.0e-9);
    }

    @Test
    public void testSanityChecks() {
        doTestSanityChecks(Decimal64Field.getInstance());
    }

    @Test
    public void testDecreasingSteps() {
        doTestDecreasingSteps(Decimal64Field.getInstance(), 1.0, 1.0, 1.0e-10);
    }

    @Test
    public void testSmallStep() {
        doTestSmallStep(Decimal64Field.getInstance(), 2.0e-13, 4.0e-12, 1.0e-12, "classical Runge-Kutta");
    }

    @Test
    public void testBigStep() {
        doTestBigStep(Decimal64Field.getInstance(), 0.0004, 0.005, 1.0e-12, "classical Runge-Kutta");

    }

    @Test
    public void testBackward() {
        doTestBackward(Decimal64Field.getInstance(), 5.0e-10, 7.0e-10, 1.0e-12, "classical Runge-Kutta");
    }

    @Test
    public void testKepler() {
        doTestKepler(Decimal64Field.getInstance(), 5.82e-3, 1.0e-5);
    }

    @Test
    public void testStepSize() {
        doTestStepSize(Decimal64Field.getInstance(), 1.0e-12);
    }

    @Test
    public void testSingleStep() {
        doTestSingleStep(Decimal64Field.getInstance(), 9.3e-9);
    }

    @Test
    public void testTooLargeFirstStep() {
        doTestTooLargeFirstStep(Decimal64Field.getInstance());
    }

    @Test
    public void testUnstableDerivative() {
        doTestUnstableDerivative(Decimal64Field.getInstance(), 1.0e-12);
    }

}