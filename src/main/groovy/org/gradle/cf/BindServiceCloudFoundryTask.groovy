/*
 * Copyright 2012 the original author or authors.
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

package org.gradle.cf

import org.gradle.api.tasks.TaskAction

/**
 * Task used to bind a service to an application.
 * 
 * @author Cedric Champeau
 */
class BindServiceCloudFoundryTask extends AbstractCloudFoundryTask {
    String serviceName
    String application

    BindServiceCloudFoundryTask() {
        super()
        description = 'Binds a service to an application'
    }

    @TaskAction
    void bindService() {
        connectToCloudFoundry()
        if (client && getServiceName()) {
            log "Binding service '${getServiceName()}' to application '${getApplication()}"
            client.bindService(getApplication(), getServiceName())
            client.logout()
        }
    }
}
