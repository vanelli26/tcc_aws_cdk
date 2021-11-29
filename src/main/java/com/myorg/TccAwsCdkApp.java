package com.myorg;

import software.amazon.awscdk.core.App;

public class TccAwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        VpcStack vpcStack = new VpcStack(app, "Vpc");

        ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        RdsStack rdsStack = new RdsStack(app, "Rds", vpcStack.getVpc());
        rdsStack.addDependency(vpcStack);

        Service01Stack service01Stack = new Service01Stack(
                app,
                "Service01",
                clusterStack.getCluster()
        );
        service01Stack.addDependency(clusterStack);
        service01Stack.addDependency(rdsStack);

        Service02Stack service02Stack = new Service02Stack(
                app,
                "Service02",
                clusterStack.getCluster()
        );
        service02Stack.addDependency(clusterStack);
        service02Stack.addDependency(rdsStack);

        app.synth();
    }
}
