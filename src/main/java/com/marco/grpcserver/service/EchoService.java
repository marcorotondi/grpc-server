package com.marco.grpcserver.service;

import io.grpc.marco.Echo;
import io.grpc.marco.GreeterGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class EchoService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(Echo.HelloRequest request, StreamObserver<Echo.HelloReply> responseObserver) {
        final Echo.HelloReply.Builder replyBuilder = Echo.HelloReply.newBuilder().setMessage("Hello " + request.getName());
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
