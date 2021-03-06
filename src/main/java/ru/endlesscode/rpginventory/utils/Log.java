/*
 * This file is part of RPGInventory.
 * Copyright (C) 2018 EndlessCode Group and contributors
 *
 * RPGInventory is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RPGInventory is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RPGInventory.  If not, see <http://www.gnu.org/licenses/>.
 */

package ru.endlesscode.rpginventory.utils;

import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("CheckStyle")
public final class Log {

    private static Logger logger;

    private Log() {
        // static class
    }

    public static void init(@NotNull Logger logger) {
        Log.logger = logger;
    }

    public static void i(@NotNull String message, Object... args) {
        logger.info(prepareMessage(message, args));
    }

    public static void w(Throwable t) {
        logger.log(Level.WARNING, t.getMessage(), t);
    }

    public static void w(@NotNull String message, Object... args) {
        logger.warning(prepareMessage(message, args));
    }

    public static void w(Throwable t, @NotNull String message, Object... args) {
        logger.log(Level.WARNING, prepareMessage(message, args), t);
    }

    public static void d(Throwable t) {
        logger.log(Level.FINE, "", t);
    }

    public static void s(@NotNull String message, Object... args) {
        logger.severe(prepareMessage(message, args));
    }

    private static String prepareMessage(String message, Object... args) {
        return MessageFormat.format(message, args);
    }
}
