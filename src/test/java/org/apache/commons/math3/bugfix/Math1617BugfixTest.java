package org.apache.commons.math3.bugfix;

import org.apache.commons.math3.linear.FieldLUDecomposition;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.util.BigReal;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test for bugfix of library issue: https://issues.apache.org/jira/browse/MATH-1617. See more details here:
 * https://stackoverflow.com/questions/68427448/how-to-find-the-inverse-of-a-matrix-using-apache-commons-math-library-in-java/68427869
 */

public class Math1617BugfixTest {

    @Test
    public void testMath1617Bugfix() {

        BigReal[][] leftMatrixData = new BigReal[][] {
                { new BigReal(1), new BigReal(0), new BigReal(0), new BigReal(0) },
                { new BigReal(1), new BigReal(0), new BigReal(1), new BigReal(0) },
                { new BigReal(1), new BigReal(1), new BigReal(0), new BigReal(0) },
                { new BigReal(1), new BigReal(1), new BigReal(1), new BigReal(1) },
        };

        FieldMatrix<BigReal> leftMatrix = MatrixUtils.createFieldMatrix(leftMatrixData);
        FieldLUDecomposition<BigReal> luDecomposition = new FieldLUDecomposition<BigReal>(leftMatrix);

        // assertions
        assertEquals(new BigReal(-1), luDecomposition.getDeterminant());
        assertArrayEquals(new int[]{0, 2, 1, 3}, luDecomposition.getPivot());

        FieldMatrix<BigReal> leftMatrixInverse = luDecomposition.getSolver().getInverse();

    }

}
