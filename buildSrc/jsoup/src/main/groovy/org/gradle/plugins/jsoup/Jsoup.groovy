/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.plugins.jsoup

import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.OutputFile
import org.gradle.util.ConfigureUtil
import org.jsoup.nodes.Document

class Jsoup extends SourceTask {
    
    @Input
    String inputEncoding

    @Input
    String outputEncoding

    List<Closure> transforms = []

    private destination

    void setDestination(destination) {
        this.destination = destination
    }

    @OutputFile
    def getDestination() {
        return project.file(destination)
    }
    
    @TaskAction 
    void doTransform() {
        Document document = org.jsoup.Jsoup.parse(getSource().singleFile.getText(getInputEncoding()))
        document.outputSettings().charset(getOutputEncoding())
        getTransforms().each { ConfigureUtil.configure(it, document) }
        getDestination().setText(document.toString(), getOutputEncoding())
    }

    void transform(Closure transform) {
        this.transforms << transform
    }
    
}
