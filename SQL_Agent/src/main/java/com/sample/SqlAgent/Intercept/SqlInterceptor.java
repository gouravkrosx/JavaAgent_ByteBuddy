package com.sample.SqlAgent.Intercept;

import com.mysql.cj.PreparedQuery;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import com.mysql.jdbc.Driver;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.concurrent.Callable;

public class SqlInterceptor {

    public static ResultSetInternalMethods sqlQueryDirect(
            @This
            Object zuper,
            @SuperCall
            Callable<ResultSetInternalMethods> client,
            @AllArguments
            Object[] args) throws Exception {
        Statement statement = (Statement) args[0];
        if (statement instanceof PreparedQuery) {
            try {
                String sql = ((PreparedQuery) statement).asSql();
                InetSocketAddress inetSocketAddress = (InetSocketAddress) ((Driver) zuper).connect()
//                SocketAddress remoteSocketAddr = conn.getIO().mysqlConnection.getRemoteSocketAddress();

                int ipv4 = ByteBuffer.wrap(inetSocketAddress.getAddress().getAddress()).getInt();
                int port = inetSocketAddress.getPort();
                System.out.println("ipv4 is " + ipv4 + ", port is " + port);
                ResultSetInternalMethods response = client.call();
                return response;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                ResultSetInternalMethods response = client.call();
                return response;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
