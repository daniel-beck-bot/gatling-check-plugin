package org.jenkinsci.plugins.gatlingcheck.metrics;

import hudson.Extension;
import hudson.model.Descriptor;
import org.jenkinsci.plugins.gatlingcheck.constant.MetricType;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nonnull;

public final class ResponseTime95Metric extends AbstractMetric {

    private final String responseTime;

    @DataBoundConstructor
    public ResponseTime95Metric(String responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public MetricType getType() {
        return MetricType.RESPONSE_TIME_95;
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<AbstractMetric> {

        @Nonnull
        @Override
        public String getDisplayName() {
            return ".95 响应时间预警";
        }
    }

    public String getResponseTime() {
        return responseTime;
    }

    public double getResponseTimeAsDouble() {
        return Double.valueOf(responseTime);
    }
}
