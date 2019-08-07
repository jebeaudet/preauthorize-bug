/**
 * Copyright (c) 2011 - 2019, Coveo Solutions Inc.
 */
package jebeaudet;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.management.HeapDumpWebEndpoint;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = HeapDumpWebEndpoint.class)
public class PreAuthorizeEndpoint
{
    private HeapDumpWebEndpoint delegate;

    public PreAuthorizeEndpoint(HeapDumpWebEndpoint delegate)
    {
        this.delegate = delegate;
    }

    @PreAuthorize("irrelvant")
    @ReadOperation
    public WebEndpointResponse<Resource> heapDump(@Nullable Boolean live)
    {
        return delegate.heapDump(live);
    }
}
