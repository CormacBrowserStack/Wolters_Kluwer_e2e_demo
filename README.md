# Lloyds_bank_BS_demo

## Prerequisites
`nodejs`<br />
`npm`<br />
`mvn`<br />

**NOTES**:<br />
If you are running this **locally**, make sure you have the following env vars set in your local environment.<br />
If you are running this from **CI**, make sure they are set in your SCM/CI-CD tool.

`BROWSERSTACK_USERNAME`<br />
`BROWSERSTACK_ACCESS_KEY`<br />
`PERCY_TOKEN`<br />

### For single test with percy snapshot
`export BROWSERSTACK_CONFIG_FILE="./config/browserstack-single.yml"`<br />
`npx percy exec -- mvn test -P sample-test`

### For parallel test run
`export BROWSERSTACK_CONFIG_FILE="./config/browserstack-parallel.yml"`<br />
`mvn test -P sample-test`