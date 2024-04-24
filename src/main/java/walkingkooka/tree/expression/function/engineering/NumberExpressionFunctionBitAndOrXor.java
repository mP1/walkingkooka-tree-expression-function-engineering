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
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterKind;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Bit AND, OR and XOR functions.
 * Note that unlike Excel all functions accept negative values.
 * <br>
 * https://exceljet.net/excel-functions/excel-bitand-function
 * <br>
 * https://exceljet.net/excel-functions/excel-bitor-function
 * <br>
 * https://exceljet.net/excel-functions/excel-bitxor-function
 */
final class NumberExpressionFunctionBitAndOrXor<C extends ExpressionEvaluationContext> extends NumberExpressionFunction<C> {

    /**
     * BITAND getter.
     */
    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionBitAndOrXor<C> bitAnd() {
        return Cast.to(BITAND);
    }

    /**
     * Singleton
     */
    private static final NumberExpressionFunctionBitAndOrXor<?> BITAND = new NumberExpressionFunctionBitAndOrXor<>(
            "bitand",
            (n1, n2) -> n1.and(n2)
    );

    /**
     * BITOR getter.
     */
    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionBitAndOrXor<C> bitOr() {
        return Cast.to(BITOR);
    }

    /**
     * Singleton
     */
    private static final NumberExpressionFunctionBitAndOrXor<?> BITOR = new NumberExpressionFunctionBitAndOrXor<>(
            "bitor",
            (n1, n2) -> n1.or(n2)
    );

    /**
     * BITXOR getter.
     */
    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionBitAndOrXor<C> bitXor() {
        return Cast.to(BITXOR);
    }

    /**
     * Singleton
     */
    private static final NumberExpressionFunctionBitAndOrXor<?> BITXOR = new NumberExpressionFunctionBitAndOrXor<>(
            "bitxor",
            (n1, n2) -> n1.xor(n2)
    );

    /**
     * Private ctor
     */
    private NumberExpressionFunctionBitAndOrXor(final String name,
                                                final BiFunction<ExpressionNumber, ExpressionNumber, ExpressionNumber> function) {
        super(name);
        this.function = function;
    }

    @Override
    public ExpressionNumber apply(final List<Object> parameters,
                                  final C context) {
        this.checkParameterCount(parameters);

        return this.function.apply(
                NUMBER1.getOrFail(parameters, 0),
                NUMBER2.getOrFail(parameters, 1)
        );
    }

    private final BiFunction<ExpressionNumber, ExpressionNumber, ExpressionNumber> function;

    private final static ExpressionFunctionParameter<ExpressionNumber> NUMBER1 = ExpressionFunctionParameterName.with("number1")
            .required(ExpressionNumber.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_RESOLVE_REFERENCES);

    private final static ExpressionFunctionParameter<ExpressionNumber> NUMBER2 = ExpressionFunctionParameterName.with("number2")
            .required(ExpressionNumber.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_RESOLVE_REFERENCES);

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = Lists.of(
            NUMBER1,
            NUMBER2
    );
}
