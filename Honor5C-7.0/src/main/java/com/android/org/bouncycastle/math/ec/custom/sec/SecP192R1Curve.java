package com.android.org.bouncycastle.math.ec.custom.sec;

import com.android.org.bouncycastle.math.ec.ECCurve;
import com.android.org.bouncycastle.math.ec.ECCurve.AbstractFp;
import com.android.org.bouncycastle.math.ec.ECFieldElement;
import com.android.org.bouncycastle.math.ec.ECPoint;
import com.android.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

public class SecP192R1Curve extends AbstractFp {
    private static final int SecP192R1_DEFAULT_COORDS = 2;
    public static final BigInteger q = null;
    protected SecP192R1Point infinity;

    static {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.android.org.bouncycastle.math.ec.custom.sec.SecP192R1Curve.<clinit>():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: jadx.core.utils.exceptions.DecodeException:  in method: com.android.org.bouncycastle.math.ec.custom.sec.SecP192R1Curve.<clinit>():void
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:46)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:98)
	... 5 more
Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1197)
	at com.android.dx.io.OpcodeInfo.getFormat(OpcodeInfo.java:1212)
	at com.android.dx.io.instructions.DecodedInstruction.decode(DecodedInstruction.java:72)
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:43)
	... 6 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.org.bouncycastle.math.ec.custom.sec.SecP192R1Curve.<clinit>():void");
    }

    public SecP192R1Curve() {
        super(q);
        this.infinity = new SecP192R1Point(this, null, null);
        this.a = fromBigInteger(new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.b = fromBigInteger(new BigInteger(1, Hex.decode("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.order = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = SecP192R1_DEFAULT_COORDS;
    }

    protected ECCurve cloneCurve() {
        return new SecP192R1Curve();
    }

    public boolean supportsCoordinateSystem(int coord) {
        switch (coord) {
            case SecP192R1_DEFAULT_COORDS /*2*/:
                return true;
            default:
                return false;
        }
    }

    public BigInteger getQ() {
        return q;
    }

    public int getFieldSize() {
        return q.bitLength();
    }

    public ECFieldElement fromBigInteger(BigInteger x) {
        return new SecP192R1FieldElement(x);
    }

    protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, boolean withCompression) {
        return new SecP192R1Point(this, x, y, withCompression);
    }

    protected ECPoint createRawPoint(ECFieldElement x, ECFieldElement y, ECFieldElement[] zs, boolean withCompression) {
        return new SecP192R1Point(this, x, y, zs, withCompression);
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }
}
