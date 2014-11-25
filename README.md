Fabric8 Gateway for UnifiedPush Server
======================================

If you want to run the Unified Push Server behind a firewall, you need to at least make sure that a few of its [RESTful APIs](http://aerogear.org/docs/specs/aerogear-unifiedpush-rest/overview-index.html) are still available on the internet, in oder to have mobile devices registering against it.

This project shows how to write a simple gateway/proxy, exposing only a those endpoints that deal with the device (un)registration.

Inside of the `WEB-INF` folder, the `ups-proxy-config.json` contains the following rules
```json
{ "rulebase" : [
    { "rule": "/rest/registry/device", "to": "http://INTERNAL_IP:YOUR_PORT/ag-push/rest/registry/device"},
    { "rule": "/rest/registry/device/{token}", "to": "http://INTERNAL_IP:YOUR_PORT/ag-push/rest/registry/device/{token}"}
]}
```

With this configuration mobile apps on the devices will register against the Unified Push Server, going through this proxy.

Have fun!
