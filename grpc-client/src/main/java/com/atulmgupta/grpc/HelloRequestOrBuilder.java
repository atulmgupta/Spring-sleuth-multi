// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HelloService.proto

package com.atulmgupta.grpc;

public interface HelloRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.atulmgupta.grpc.HelloRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string firstName = 1;</code>
   * @return The firstName.
   */
  String getFirstName();
  /**
   * <code>string firstName = 1;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string lastName = 2;</code>
   * @return The lastName.
   */
  String getLastName();
  /**
   * <code>string lastName = 2;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();
}
