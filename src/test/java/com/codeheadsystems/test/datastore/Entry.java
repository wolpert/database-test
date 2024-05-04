/*
 *    Copyright (c) 2022 Ned Wolpert <ned.wolpert@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.codeheadsystems.test.datastore;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * The type Entry.
 */
@DynamoDBTable(tableName = "ATable")
public class Entry {

  private String hash;
  private String range;
  private String attribute;

  /**
   * Instantiates a new Entry.
   */
  public Entry() {

  }

  /**
   * Instantiates a new Entry.
   *
   * @param hash  the hash
   * @param range the range
   */
  public Entry(String hash, String range) {
    this.hash = hash;
    this.range = range;
  }

  /**
   * Instantiates a new Entry.
   *
   * @param hash  the hash
   * @param range the range
   * @param attr  the attr
   */
  public Entry(String hash, String range, String attr) {
    this.hash = hash;
    this.range = range;
    this.attribute = attr;
  }

  /**
   * Gets hash.
   *
   * @return the hash
   */
  @DynamoDBHashKey(attributeName = "hash")
  public String getHash() {
    return hash;
  }

  /**
   * Sets hash.
   *
   * @param hash the hash
   */
  public void setHash(final String hash) {
    this.hash = hash;
  }

  /**
   * Gets range.
   *
   * @return the range
   */
  @DynamoDBRangeKey(attributeName = "range")
  public String getRange() {
    return range;
  }

  /**
   * Sets range.
   *
   * @param range the range
   */
  public void setRange(final String range) {
    this.range = range;
  }

  /**
   * Gets attribute.
   *
   * @return the attribute
   */
  @DynamoDBAttribute(attributeName = "attribute")
  public String getAttribute() {
    return attribute;
  }

  /**
   * Sets attribute.
   *
   * @param attribute the attribute
   */
  public void setAttribute(final String attribute) {
    this.attribute = attribute;
  }
}
