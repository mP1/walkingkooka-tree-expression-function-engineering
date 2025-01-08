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

import walkingkooka.collect.set.Sets;
import walkingkooka.net.Url;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.provider.ExpressionFunctionProvider;
import walkingkooka.tree.expression.function.provider.ExpressionFunctionProviders;

/**
 * Collection of static factory methods for numerous {@link ExpressionFunction}.
 */
public final class EngineeringExpressionFunctions implements PublicStaticHelper {


    /**
     * An {@link ExpressionFunctionProvider} with all the functions in this project.
     */
    public static ExpressionFunctionProvider expressionFunctionProvider(final CaseSensitivity nameCaseSensitivity) {
        return ExpressionFunctionProviders
            .basic(
                Url.parseAbsolute("https://github.com/mP1/walkingkooka-tree-expression-function-engineering/"),
                nameCaseSensitivity,
                Sets.of(
                    bin2dec(),
                    bin2hex(),
                    bin2oct(),
                    bitAnd(),
                    bitOr(),
                    bitXor(),
                    dec2bin(),
                    dec2hex(),
                    dec2oct(),
                    delta(),
                    hex2bin(),
                    hex2dec(),
                    hex2oct(),
                    oct2bin(),
                    oct2dec(),
                    oct2hex()
                )
            );
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#bin2dec}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> bin2dec() {
        return StringExpressionFunctionParseBase2Base.bin2dec();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#bin2hex}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> bin2hex() {
        return StringExpressionFunctionParseBase2Base.bin2hex();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#bin2oct}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> bin2oct() {
        return StringExpressionFunctionParseBase2Base.bin2oct();
    }

    /**
     * {@see NumberExpressionFunctionBitAndOrXor#bitAnd}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> bitAnd() {
        return NumberExpressionFunctionBitAndOrXor.bitAnd();
    }

    /**
     * {@see NumberExpressionFunctionBitAndOrXor#bitOr}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> bitOr() {
        return NumberExpressionFunctionBitAndOrXor.bitOr();
    }

    /**
     * {@see NumberExpressionFunctionBitAndOrXor#bitXor}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> bitXor() {
        return NumberExpressionFunctionBitAndOrXor.bitXor();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#dec2bin}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> dec2bin() {
        return StringExpressionFunctionParseBase2Base.dec2bin();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#dec2hex}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> dec2hex() {
        return StringExpressionFunctionParseBase2Base.dec2hex();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#dec2oct}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> dec2oct() {
        return StringExpressionFunctionParseBase2Base.dec2oct();
    }

    /**
     * {@see BooleanExpressionFunctionDelta#instance}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<Boolean, C> delta() {
        return BooleanExpressionFunctionDelta.instance();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#hex2bin}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> hex2bin() {
        return StringExpressionFunctionParseBase2Base.hex2bin();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#hex2dec}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> hex2dec() {
        return StringExpressionFunctionParseBase2Base.hex2dec();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#hex2oct}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> hex2oct() {
        return StringExpressionFunctionParseBase2Base.hex2oct();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#oct2bin}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> oct2bin() {
        return StringExpressionFunctionParseBase2Base.oct2bin();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#oct2dec}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> oct2dec() {
        return StringExpressionFunctionParseBase2Base.oct2dec();
    }

    /**
     * {@see StringExpressionFunctionParseBase2Base#oct2hex}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> oct2hex() {
        return StringExpressionFunctionParseBase2Base.oct2hex();
    }

    /**
     * Stops creation
     */
    private EngineeringExpressionFunctions() {
        throw new UnsupportedOperationException();
    }
}
