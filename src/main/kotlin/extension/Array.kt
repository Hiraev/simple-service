package extension

inline fun <S, T : S> Array<out T>.reduceUntil(
        predicate: (acc: S) -> Boolean,
        operation: (acc: S, elem: T) -> S
): Pair<S, Int> {
    if (isEmpty()) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = this[0]
    for (i in 1..lastIndex) {
        if (!predicate(accumulator)) return accumulator to i - 1
        accumulator = operation(accumulator, this[i])
    }
    return accumulator to lastIndex
}
