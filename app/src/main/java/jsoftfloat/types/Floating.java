package jsoftfloat.types;

import jsoftfloat.Environment;
import jsoftfloat.internal.ExactFloat;

/**
 * General classifications that any floating point class needs to provide.
 */
public interface Floating<T extends Floating<T>> {
    // TODO: order/group these
    public boolean isSignMinus();

    public boolean isInfinite();

    public boolean isFinite();

    public boolean isNormal();

    public boolean isSubnormal();

    public boolean isNaN();

    public boolean isSignalling();

    public boolean isCanonical();

    public boolean isZero();

    // TODO: consider making a full bit field representation method for generic conversions
    public int maxPrecision();

    public T NaN();

    public T Zero();

    public T NegativeZero();

    public T Infinity();

    public T NegativeInfinity();

    public T fromExactFloat(ExactFloat f, Environment env);

    public ExactFloat toExactFloat();

    public T negate();

}
