# Lloyds_bank_BS_demo

## Prerequisites
`npm install`

### For single test with percy snapshot
`export BROWSERSTACK_CONFIG_FILE="./config/browserstack-single.yml" && npx percy exec -- mvn test -P sample-test`

### For parallel test run
`export BROWSERSTACK_CONFIG_FILE="./config/browserstack-parallel.yml" && mvn test -P sample-test`