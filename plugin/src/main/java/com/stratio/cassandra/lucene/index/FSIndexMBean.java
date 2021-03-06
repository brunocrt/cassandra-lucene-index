/*
 * Copyright (C) 2014 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.cassandra.lucene.index;

/**
 * @author Andres de la Pena {@literal <adelapena@stratio.com>}
 */
public interface FSIndexMBean {

    /**
     * Commits the pending changes.
     */
    void commit();

    /**
     * Returns the total number of {@link org.apache.lucene.document.Document}s in this index.
     *
     * @return the number of {@link org.apache.lucene.document.Document}s
     */
    int getNumDocs();

    /**
     * Returns the total number of deleted {@link org.apache.lucene.document.Document}s in this index.
     *
     * @return the number of deleted {@link org.apache.lucene.document.Document}s
     */
    int getNumDeletedDocs();

    /**
     * Optimizes the index forcing merge segments leaving the specified number of segments. This operation may block
     * until all merging completes.
     *
     * @param maxNumSegments the maximum number of segments left in the index after merging finishes
     * @param doWait {@code true} if the call should block until the operation completes
     */
    void forceMerge(int maxNumSegments, boolean doWait);

    /**
     * Optimizes the index forcing merge of all segments that have deleted documents.. This operation may block until
     * all merging completes.
     *
     * @param doWait {@code true} if the call should block until the operation completes
     */
    void forceMergeDeletes(boolean doWait);

    /**
     * Refreshes the index readers.
     */
    void refresh();
}
