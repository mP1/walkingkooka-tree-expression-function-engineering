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

import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterKind;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.util.List;

final class StringExpressionFunctionParseBase2Base<C extends ExpressionEvaluationContext> extends StringExpressionFunction<C> {

    // BIN2.............................................................................................................

    // https://exceljet.net/excel-functions/excel-bin2dec-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> bin2dec() {
        return Cast.to(BIN2DEC);
    }

    private final static StringExpressionFunctionParseBase2Base<?> BIN2DEC = new StringExpressionFunctionParseBase2Base<>("bin2dec", 2, 10);

    // https://exceljet.net/excel-functions/excel-bin2hex-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> bin2hex() {
        return Cast.to(BIN2HEX);
    }

    private final static StringExpressionFunctionParseBase2Base<?> BIN2HEX = new StringExpressionFunctionParseBase2Base<>("bin2hex", 2, 16);

    // https://exceljet.net/excel-functions/excel-bin2oct-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> bin2oct() {
        return Cast.to(BIN2OCT);
    }

    private final static StringExpressionFunctionParseBase2Base<?> BIN2OCT = new StringExpressionFunctionParseBase2Base<>("bin2oct", 2, 8);

    // DEC2.............................................................................................................

    // https://exceljet.net/excel-functions/excel-dec2bin-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> dec2bin() {
        return Cast.to(DEC2BIN);
    }

    private final static StringExpressionFunctionParseBase2Base<?> DEC2BIN = new StringExpressionFunctionParseBase2Base<>("dec2bin", 10, 2);

    // https://exceljet.net/excel-functions/excel-dec2hex-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> dec2hex() {
        return Cast.to(DEC2HEX);
    }

    private final static StringExpressionFunctionParseBase2Base<?> DEC2HEX = new StringExpressionFunctionParseBase2Base<>("dec2hex", 10, 16);

    // https://exceljet.net/excel-functions/excel-dec2oct-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> dec2oct() {
        return Cast.to(DEC2OCT);
    }

    private final static StringExpressionFunctionParseBase2Base<?> DEC2OCT = new StringExpressionFunctionParseBase2Base<>("dec2oct", 10, 8);

    // HEX2.............................................................................................................

    // https://exceljet.net/excel-functions/excel-hex2bin-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> hex2bin() {
        return Cast.to(HEX2BIN);
    }

    private final static StringExpressionFunctionParseBase2Base<?> HEX2BIN = new StringExpressionFunctionParseBase2Base<>("hex2bin", 16, 2);

    // https://exceljet.net/excel-functions/excel-hex2dec-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> hex2dec() {
        return Cast.to(HEX2DEC);
    }

    private final static StringExpressionFunctionParseBase2Base<?> HEX2DEC = new StringExpressionFunctionParseBase2Base<>("hex2dec", 16, 10);

    // https://exceljet.net/excel-functions/excel-hex2oct-function

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> hex2oct() {
        return Cast.to(HEX2OCT);
    }

    private final static StringExpressionFunctionParseBase2Base<?> HEX2OCT = new StringExpressionFunctionParseBase2Base<>("hex2oct", 16, 8);

    // OCT2.............................................................................................................

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> oct2bin() {
        return Cast.to(OCT2BIN);
    }

    private final static StringExpressionFunctionParseBase2Base<?> OCT2BIN = new StringExpressionFunctionParseBase2Base<>("oct2bin", 8, 2);

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> oct2dec() {
        return Cast.to(OCT2DEC);
    }

    private final static StringExpressionFunctionParseBase2Base<?> OCT2DEC = new StringExpressionFunctionParseBase2Base<>("oct2dec", 8, 10);

    static <C extends ExpressionEvaluationContext> StringExpressionFunctionParseBase2Base<C> oct2hex() {
        return Cast.to(OCT2HEX);
    }

    private final static StringExpressionFunctionParseBase2Base<?> OCT2HEX = new StringExpressionFunctionParseBase2Base<>("oct2hex", 8, 16);

    /**
     * Private ctor.
     */
    private StringExpressionFunctionParseBase2Base(final String name,
                                                   final int parseWithBase,
                                                   final int formatWithBase) {
        super(name);
        this.parseWithBase = parseWithBase;
        this.formatWithBase = formatWithBase;
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<String> FROM = ExpressionFunctionParameterName.with("from")
            .required(String.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_RESOLVE_REFERENCES);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = Lists.of(
            FROM
    );

    @Override
    public String apply(final List<Object> parameters,
                        final C context) {
        this.checkParameterCount(parameters);

        final ExpressionNumberKind kind = context.expressionNumberKind();

        final ExpressionNumber parsed = kind.parseWithBase(
                FROM.getOrFail(parameters, 0),
                this.parseWithBase,
                context
        );

        return parsed.toStringWithBase(
                kind.create(formatWithBase)
        ).toLowerCase(context.locale());
    }

    private final int parseWithBase;

    private final int formatWithBase;
}
