/***********************************************************************
 * Copyright (c) 2013-2018 Commonwealth Computer Research, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, Version 2.0
 * which accompanies this distribution and is available at
 * http://www.opensource.org/licenses/apache2.0.php.
 ***********************************************************************/

package org.locationtech.geomesa.hbase.index

import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.io.encoding.DataBlockEncoding
import org.locationtech.geomesa.hbase.data._
import org.locationtech.geomesa.hbase.index.HBaseIndexAdapter.ScanConfig
import org.locationtech.geomesa.index.index.id.IdIndex

case object HBaseIdIndex extends HBaseIdLikeIndex with HBasePlatform

trait HBaseIdLikeIndex extends HBaseFeatureIndex with HBaseIndexAdapter
    with IdIndex[HBaseDataStore, HBaseFeature, Mutation, Scan, ScanConfig] {
  override protected val dataBlockEncoding: Option[DataBlockEncoding] = None
  override val version: Int = 1
}
