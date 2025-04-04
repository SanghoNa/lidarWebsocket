package sensr_proto;
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sensr_proto/global_type.proto

public final class GlobalType {
  private GlobalType() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface Vector2OrBuilder extends
      // @@protoc_insertion_point(interface_extends:Vector2)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>float x = 1;</code>
     * @return The x.
     */
    float getX();

    /**
     * <code>float y = 2;</code>
     * @return The y.
     */
    float getY();
  }
  /**
   * Protobuf type {@code Vector2}
   */
  public static final class Vector2 extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Vector2)
      Vector2OrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Vector2.newBuilder() to construct.
    private Vector2(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Vector2() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Vector2();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return GlobalType.internal_static_Vector2_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return GlobalType.internal_static_Vector2_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GlobalType.Vector2.class, GlobalType.Vector2.Builder.class);
    }

    public static final int X_FIELD_NUMBER = 1;
    private float x_ = 0F;
    /**
     * <code>float x = 1;</code>
     * @return The x.
     */
    @java.lang.Override
    public float getX() {
      return x_;
    }

    public static final int Y_FIELD_NUMBER = 2;
    private float y_ = 0F;
    /**
     * <code>float y = 2;</code>
     * @return The y.
     */
    @java.lang.Override
    public float getY() {
      return y_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (java.lang.Float.floatToRawIntBits(x_) != 0) {
        output.writeFloat(1, x_);
      }
      if (java.lang.Float.floatToRawIntBits(y_) != 0) {
        output.writeFloat(2, y_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (java.lang.Float.floatToRawIntBits(x_) != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(1, x_);
      }
      if (java.lang.Float.floatToRawIntBits(y_) != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, y_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof GlobalType.Vector2)) {
        return super.equals(obj);
      }
      GlobalType.Vector2 other = (GlobalType.Vector2) obj;

      if (java.lang.Float.floatToIntBits(getX())
          != java.lang.Float.floatToIntBits(
              other.getX())) return false;
      if (java.lang.Float.floatToIntBits(getY())
          != java.lang.Float.floatToIntBits(
              other.getY())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + X_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getX());
      hash = (37 * hash) + Y_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getY());
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static GlobalType.Vector2 parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GlobalType.Vector2 parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GlobalType.Vector2 parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GlobalType.Vector2 parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GlobalType.Vector2 parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GlobalType.Vector2 parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GlobalType.Vector2 parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GlobalType.Vector2 parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static GlobalType.Vector2 parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static GlobalType.Vector2 parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static GlobalType.Vector2 parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GlobalType.Vector2 parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(GlobalType.Vector2 prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Vector2}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Vector2)
        GlobalType.Vector2OrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return GlobalType.internal_static_Vector2_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return GlobalType.internal_static_Vector2_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                GlobalType.Vector2.class, GlobalType.Vector2.Builder.class);
      }

      // Construct using GlobalType.Vector2.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        x_ = 0F;
        y_ = 0F;
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return GlobalType.internal_static_Vector2_descriptor;
      }

      @java.lang.Override
      public GlobalType.Vector2 getDefaultInstanceForType() {
        return GlobalType.Vector2.getDefaultInstance();
      }

      @java.lang.Override
      public GlobalType.Vector2 build() {
        GlobalType.Vector2 result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public GlobalType.Vector2 buildPartial() {
        GlobalType.Vector2 result = new GlobalType.Vector2(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(GlobalType.Vector2 result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.x_ = x_;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.y_ = y_;
        }
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof GlobalType.Vector2) {
          return mergeFrom((GlobalType.Vector2)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(GlobalType.Vector2 other) {
        if (other == GlobalType.Vector2.getDefaultInstance()) return this;
        if (other.getX() != 0F) {
          setX(other.getX());
        }
        if (other.getY() != 0F) {
          setY(other.getY());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 13: {
                x_ = input.readFloat();
                bitField0_ |= 0x00000001;
                break;
              } // case 13
              case 21: {
                y_ = input.readFloat();
                bitField0_ |= 0x00000002;
                break;
              } // case 21
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private float x_ ;
      /**
       * <code>float x = 1;</code>
       * @return The x.
       */
      @java.lang.Override
      public float getX() {
        return x_;
      }
      /**
       * <code>float x = 1;</code>
       * @param value The x to set.
       * @return This builder for chaining.
       */
      public Builder setX(float value) {

        x_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>float x = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearX() {
        bitField0_ = (bitField0_ & ~0x00000001);
        x_ = 0F;
        onChanged();
        return this;
      }

      private float y_ ;
      /**
       * <code>float y = 2;</code>
       * @return The y.
       */
      @java.lang.Override
      public float getY() {
        return y_;
      }
      /**
       * <code>float y = 2;</code>
       * @param value The y to set.
       * @return This builder for chaining.
       */
      public Builder setY(float value) {

        y_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <code>float y = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearY() {
        bitField0_ = (bitField0_ & ~0x00000002);
        y_ = 0F;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Vector2)
    }

    // @@protoc_insertion_point(class_scope:Vector2)
    private static final GlobalType.Vector2 DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new GlobalType.Vector2();
    }

    public static GlobalType.Vector2 getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Vector2>
        PARSER = new com.google.protobuf.AbstractParser<Vector2>() {
      @java.lang.Override
      public Vector2 parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<Vector2> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Vector2> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public GlobalType.Vector2 getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Vector3OrBuilder extends
      // @@protoc_insertion_point(interface_extends:Vector3)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>float x = 1;</code>
     * @return The x.
     */
    float getX();

    /**
     * <code>float y = 2;</code>
     * @return The y.
     */
    float getY();

    /**
     * <code>float z = 3;</code>
     * @return The z.
     */
    float getZ();
  }
  /**
   * Protobuf type {@code Vector3}
   */
  public static final class Vector3 extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Vector3)
      Vector3OrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Vector3.newBuilder() to construct.
    private Vector3(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Vector3() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Vector3();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return GlobalType.internal_static_Vector3_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return GlobalType.internal_static_Vector3_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GlobalType.Vector3.class, GlobalType.Vector3.Builder.class);
    }

    public static final int X_FIELD_NUMBER = 1;
    private float x_ = 0F;
    /**
     * <code>float x = 1;</code>
     * @return The x.
     */
    @java.lang.Override
    public float getX() {
      return x_;
    }

    public static final int Y_FIELD_NUMBER = 2;
    private float y_ = 0F;
    /**
     * <code>float y = 2;</code>
     * @return The y.
     */
    @java.lang.Override
    public float getY() {
      return y_;
    }

    public static final int Z_FIELD_NUMBER = 3;
    private float z_ = 0F;
    /**
     * <code>float z = 3;</code>
     * @return The z.
     */
    @java.lang.Override
    public float getZ() {
      return z_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (java.lang.Float.floatToRawIntBits(x_) != 0) {
        output.writeFloat(1, x_);
      }
      if (java.lang.Float.floatToRawIntBits(y_) != 0) {
        output.writeFloat(2, y_);
      }
      if (java.lang.Float.floatToRawIntBits(z_) != 0) {
        output.writeFloat(3, z_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (java.lang.Float.floatToRawIntBits(x_) != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(1, x_);
      }
      if (java.lang.Float.floatToRawIntBits(y_) != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, y_);
      }
      if (java.lang.Float.floatToRawIntBits(z_) != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(3, z_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof GlobalType.Vector3)) {
        return super.equals(obj);
      }
      GlobalType.Vector3 other = (GlobalType.Vector3) obj;

      if (java.lang.Float.floatToIntBits(getX())
          != java.lang.Float.floatToIntBits(
              other.getX())) return false;
      if (java.lang.Float.floatToIntBits(getY())
          != java.lang.Float.floatToIntBits(
              other.getY())) return false;
      if (java.lang.Float.floatToIntBits(getZ())
          != java.lang.Float.floatToIntBits(
              other.getZ())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + X_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getX());
      hash = (37 * hash) + Y_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getY());
      hash = (37 * hash) + Z_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getZ());
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static GlobalType.Vector3 parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GlobalType.Vector3 parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GlobalType.Vector3 parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GlobalType.Vector3 parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GlobalType.Vector3 parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GlobalType.Vector3 parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GlobalType.Vector3 parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GlobalType.Vector3 parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static GlobalType.Vector3 parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static GlobalType.Vector3 parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static GlobalType.Vector3 parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GlobalType.Vector3 parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(GlobalType.Vector3 prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Vector3}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Vector3)
        GlobalType.Vector3OrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return GlobalType.internal_static_Vector3_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return GlobalType.internal_static_Vector3_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                GlobalType.Vector3.class, GlobalType.Vector3.Builder.class);
      }

      // Construct using GlobalType.Vector3.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        x_ = 0F;
        y_ = 0F;
        z_ = 0F;
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return GlobalType.internal_static_Vector3_descriptor;
      }

      @java.lang.Override
      public GlobalType.Vector3 getDefaultInstanceForType() {
        return GlobalType.Vector3.getDefaultInstance();
      }

      @java.lang.Override
      public GlobalType.Vector3 build() {
        GlobalType.Vector3 result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public GlobalType.Vector3 buildPartial() {
        GlobalType.Vector3 result = new GlobalType.Vector3(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(GlobalType.Vector3 result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.x_ = x_;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.y_ = y_;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.z_ = z_;
        }
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof GlobalType.Vector3) {
          return mergeFrom((GlobalType.Vector3)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(GlobalType.Vector3 other) {
        if (other == GlobalType.Vector3.getDefaultInstance()) return this;
        if (other.getX() != 0F) {
          setX(other.getX());
        }
        if (other.getY() != 0F) {
          setY(other.getY());
        }
        if (other.getZ() != 0F) {
          setZ(other.getZ());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 13: {
                x_ = input.readFloat();
                bitField0_ |= 0x00000001;
                break;
              } // case 13
              case 21: {
                y_ = input.readFloat();
                bitField0_ |= 0x00000002;
                break;
              } // case 21
              case 29: {
                z_ = input.readFloat();
                bitField0_ |= 0x00000004;
                break;
              } // case 29
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private float x_ ;
      /**
       * <code>float x = 1;</code>
       * @return The x.
       */
      @java.lang.Override
      public float getX() {
        return x_;
      }
      /**
       * <code>float x = 1;</code>
       * @param value The x to set.
       * @return This builder for chaining.
       */
      public Builder setX(float value) {

        x_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>float x = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearX() {
        bitField0_ = (bitField0_ & ~0x00000001);
        x_ = 0F;
        onChanged();
        return this;
      }

      private float y_ ;
      /**
       * <code>float y = 2;</code>
       * @return The y.
       */
      @java.lang.Override
      public float getY() {
        return y_;
      }
      /**
       * <code>float y = 2;</code>
       * @param value The y to set.
       * @return This builder for chaining.
       */
      public Builder setY(float value) {

        y_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <code>float y = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearY() {
        bitField0_ = (bitField0_ & ~0x00000002);
        y_ = 0F;
        onChanged();
        return this;
      }

      private float z_ ;
      /**
       * <code>float z = 3;</code>
       * @return The z.
       */
      @java.lang.Override
      public float getZ() {
        return z_;
      }
      /**
       * <code>float z = 3;</code>
       * @param value The z to set.
       * @return This builder for chaining.
       */
      public Builder setZ(float value) {

        z_ = value;
        bitField0_ |= 0x00000004;
        onChanged();
        return this;
      }
      /**
       * <code>float z = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearZ() {
        bitField0_ = (bitField0_ & ~0x00000004);
        z_ = 0F;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Vector3)
    }

    // @@protoc_insertion_point(class_scope:Vector3)
    private static final GlobalType.Vector3 DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new GlobalType.Vector3();
    }

    public static GlobalType.Vector3 getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Vector3>
        PARSER = new com.google.protobuf.AbstractParser<Vector3>() {
      @java.lang.Override
      public Vector3 parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<Vector3> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Vector3> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public GlobalType.Vector3 getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vector2_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vector2_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vector3_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vector3_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035sensr_proto/global_type.proto\"\037\n\007Vecto" +
      "r2\022\t\n\001x\030\001 \001(\002\022\t\n\001y\030\002 \001(\002\"*\n\007Vector3\022\t\n\001x" +
      "\030\001 \001(\002\022\t\n\001y\030\002 \001(\002\022\t\n\001z\030\003 \001(\002B\003\370\001\001b\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Vector2_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Vector2_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vector2_descriptor,
        new java.lang.String[] { "X", "Y", });
    internal_static_Vector3_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Vector3_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vector3_descriptor,
        new java.lang.String[] { "X", "Y", "Z", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
