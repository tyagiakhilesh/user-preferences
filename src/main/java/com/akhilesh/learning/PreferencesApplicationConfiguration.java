package com.akhilesh.learning;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PreferencesApplicationConfiguration extends Configuration {
    @Valid
    @NotNull
    private DataSourceFactory database;

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public void setDatabase(final DataSourceFactory database) {
        this.database = database;
    }
}
