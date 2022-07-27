/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.tree.expression.function.engineering;

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionEvaluationContext;

public final class StringExpressionFunctionParseBase2BaseTest extends StringExpressionFunctionTestCase<StringExpressionFunctionParseBase2Base<ExpressionEvaluationContext>> {

    // apply............................................................................................................

    // bin2............................................................................................................

    @Test
    public void testBin2Dec() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.bin2dec(),
                "101",
                "5"
        );
    }

    @Test
    public void testBin2Hex() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.bin2hex(),
                "1010",
                "a"
        );
    }

    @Test
    public void testBin2Oct() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.bin2oct(),
                "10101010",
                "252"
        );
    }

    // dec2............................................................................................................
    @Test
    public void testDec2bin() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.dec2bin(),
                "10",
                "1010"
        );
    }

    @Test
    public void testDec2Hex() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.dec2hex(),
                "257",
                "101"
        );
    }

    @Test
    public void testDec2Oct() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.dec2oct(),
                "10",
                "12"
        );
    }

    // hex2............................................................................................................

    @Test
    public void testHex2bin() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.hex2bin(),
                "10",
                "10000"
        );
    }

    @Test
    public void testHex2Hex() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.hex2dec(),
                "101",
                "257"
        );
    }

    @Test
    public void testHex2Oct() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.hex2oct(),
                "10",
                "20"
        );
    }

    // oct2............................................................................................................

    @Test
    public void testOct2bin() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.oct2bin(),
                "10",
                "1000"
        );
    }

    @Test
    public void testOct2dec() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.oct2dec(),
                "10",
                "8"
        );
    }

    @Test
    public void testOct2Hex() {
        this.applyAndCheck3(
                StringExpressionFunctionParseBase2Base.oct2dec(),
                "101",
                "65"
        );
    }

    private void applyAndCheck3(final StringExpressionFunctionParseBase2Base<ExpressionEvaluationContext> function,
                                final String from,
                                final String result) {
        this.applyAndCheck3(
                function,
                Lists.of(from),
                result
        );
    }

    // roundtrip.........................................................................................................

    @Test
    public void testBin2DecRoundtrip() {
        this.roundtripAndCheck(
                "101010101",
                StringExpressionFunctionParseBase2Base.bin2dec(),
                StringExpressionFunctionParseBase2Base.dec2bin()
        );
    }

    @Test
    public void testBin2OctRoundtrip() {
        this.roundtripAndCheck(
                "101010101",
                StringExpressionFunctionParseBase2Base.bin2oct(),
                StringExpressionFunctionParseBase2Base.oct2bin()
        );
    }

    @Test
    public void testBin2HexRoundtrip() {
        this.roundtripAndCheck(
                "101010101",
                StringExpressionFunctionParseBase2Base.bin2hex(),
                StringExpressionFunctionParseBase2Base.hex2bin()
        );
    }

    @Test
    public void testDec2hexRoundtrip() {
        this.roundtripAndCheck(
                "123456789",
                StringExpressionFunctionParseBase2Base.dec2hex(),
                StringExpressionFunctionParseBase2Base.hex2dec()
        );
    }

    @Test
    public void testDec2octRoundtrip() {
        this.roundtripAndCheck(
                "123456789",
                StringExpressionFunctionParseBase2Base.dec2oct(),
                StringExpressionFunctionParseBase2Base.oct2dec()
        );
    }

    @Test
    public void testOct2HexRoundtrip() {
        this.roundtripAndCheck(
                "1234567",
                StringExpressionFunctionParseBase2Base.oct2hex(),
                StringExpressionFunctionParseBase2Base.hex2oct()
        );
    }

    private void roundtripAndCheck(final String value,
                                   final StringExpressionFunctionParseBase2Base<ExpressionEvaluationContext> from,
                                   final StringExpressionFunctionParseBase2Base<ExpressionEvaluationContext> to) {
        final ExpressionEvaluationContext context = this.createContext();

        this.checkEquals(
                value,
                to.apply(
                        Lists.of(from.apply(Lists.of(value), context)),
                        context
                )
        );
    }

    // toString.........................................................................................................

    @Test
    public void testToStringBin2dec() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.bin2dec(),
                "bin2dec"
        );
    }

    @Test
    public void testToStringBin2hex() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.bin2hex(),
                "bin2hex"
        );
    }

    @Test
    public void testToStringBin2oct() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.bin2oct(),
                "bin2oct"
        );
    }

    @Test
    public void testToStringDec2bin() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.dec2bin(),
                "dec2bin"
        );
    }

    @Test
    public void testToStringDec2hex() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.dec2hex(),
                "dec2hex"
        );
    }

    @Test
    public void testToStringDec2oct() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.dec2oct(),
                "dec2oct"
        );
    }

    @Test
    public void testToStringHex2bin() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.hex2bin(),
                "hex2bin"
        );
    }

    @Test
    public void testToStringHex2Dec() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.hex2dec(),
                "hex2dec"
        );
    }

    @Test
    public void testToStringHex2oct() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.hex2oct(),
                "hex2oct"
        );
    }

    @Test
    public void testToStringOct2bin() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.oct2bin(),
                "oct2bin"
        );
    }

    @Test
    public void testToStringOct2Dec() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.oct2dec(),
                "oct2dec"
        );
    }

    @Test
    public void testToStringOct2hex() {
        this.toStringAndCheck(
                StringExpressionFunctionParseBase2Base.oct2hex(),
                "oct2hex"
        );
    }

    // classTesting....................................................................................................

    @Override
    public StringExpressionFunctionParseBase2Base<ExpressionEvaluationContext> createBiFunction() {
        return StringExpressionFunctionParseBase2Base.bin2dec();
    }

    @Override
    public int minimumParameterCount() {
        return 1;
    }

    @Override
    public Class<StringExpressionFunctionParseBase2Base<ExpressionEvaluationContext>> type() {
        return Cast.to(StringExpressionFunctionParseBase2Base.class);
    }
}
