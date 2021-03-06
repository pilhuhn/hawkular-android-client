/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.client.android.push;

import android.content.Context;
import android.os.Bundle;

import org.hawkular.client.android.util.Notifications;
import org.jboss.aerogear.android.unifiedpush.MessageHandler;

import timber.log.Timber;

public final class PushHandler implements MessageHandler {
    private static final class MessageFields {
        private MessageFields() {
        }

        public static final String TEXT = "alert";
    }

    @Override
    public void onMessage(Context context, Bundle message) {
        Timber.d("Push notification delivered a message: %s", message.getString(MessageFields.TEXT));

        Notifications.of(context).sendAlertNotification();
    }

    @Override
    public void onError() {
        Timber.d("Push notification delivered an error.");
    }

    @Override
    public void onDeleteMessage(Context context, Bundle bundle) {
        Timber.d("Push notification was deleted.");
    }
}
