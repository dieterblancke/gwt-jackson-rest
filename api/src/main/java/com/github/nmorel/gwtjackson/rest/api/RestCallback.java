/*
 * Copyright 2015 Nicolas Morel
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
 */

package com.github.nmorel.gwtjackson.rest.api;

import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Nicolas Morel
 */
public abstract class RestCallback<T> implements AsyncCallback<T> {

    public void onSuccess(Response response, T result) {
        onSuccess(result);
    }

    public void onError(Response response) {
        onFailure(RestExceptionTranslator.createStatusException(response.getStatusCode(), response.getStatusText(), response.getText()));
    }

    public void onFailure(Throwable throwable) {
        throw new RequestException(throwable);
    }
}
