package com.dggorbachev.recipeapp.base

import com.dggorbachev.recipeapp.base.functional.Either

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}
