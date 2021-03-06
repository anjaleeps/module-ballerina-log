/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.stdlib.log;

import io.ballerina.runtime.api.values.BString;

/**
 * Native function implementations of the log-api module.
 *
 * @since 1.1.0
 */
public class Utils extends AbstractLogFunction {

    public static void printExtern(BString msg, BString outputFormat) {
        logMessage(msg, getPackagePath(),
                (pkg, message) -> {
                    getLogger(pkg).info(message);
                }
                , outputFormat.toString());
    }

    public static void printErrorExtern(BString msg, BString outputFormat) {
        logMessage(msg, getPackagePath(),
                (pkg, message) -> {
                    getLogger(pkg).error(message);
                }
                , outputFormat.toString());
    }
}
