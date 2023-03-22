package com.rathna.consulting.web;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ExcecptionResolver extends DataFetcherExceptionResolverAdapter {


  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {


    return GraphqlErrorBuilder.newError(env).message("Resolved Error : ", ex.getMessage())
        .errorType(ErrorType.DataFetchingException).build();



  }
}
