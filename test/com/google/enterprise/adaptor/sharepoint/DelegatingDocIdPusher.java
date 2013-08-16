// Copyright 2013 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.enterprise.adaptor.sharepoint;

import com.google.enterprise.adaptor.Acl;
import com.google.enterprise.adaptor.DocId;
import com.google.enterprise.adaptor.DocIdPusher;
import com.google.enterprise.adaptor.PushErrorHandler;

import java.util.*;

/** Forwards all calls to delegate. */
abstract class DelegatingDocIdPusher implements DocIdPusher {
  protected abstract DocIdPusher delegate();

  @Override
  public DocId pushDocIds(Iterable<DocId> docIds)
      throws InterruptedException {
    return delegate().pushDocIds(docIds, null);
  }

  @Override
  public DocId pushDocIds(Iterable<DocId> docIds,
                          PushErrorHandler handler)
      throws InterruptedException {
    return delegate().pushDocIds(docIds, handler);
  }

  @Override
  public Record pushRecords(Iterable<Record> records)
      throws InterruptedException {
    return delegate().pushRecords(records, null);
  }

  @Override
  public Record pushRecords(Iterable<Record> records,
                            PushErrorHandler handler)
      throws InterruptedException {
    return delegate().pushRecords(records, handler);
  }

  @Override
  public DocId pushNamedResources(Map<DocId, Acl> resources)
      throws InterruptedException {
    return delegate().pushNamedResources(resources, null);
  }

  @Override
  public DocId pushNamedResources(Map<DocId, Acl> resources,
                                  PushErrorHandler handler)
      throws InterruptedException {
    return delegate().pushNamedResources(resources, handler);
  }
}