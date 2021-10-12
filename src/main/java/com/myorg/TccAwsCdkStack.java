package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

public class TccAwsCdkStack extends Stack {
    public TccAwsCdkStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public TccAwsCdkStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here
    }
}
