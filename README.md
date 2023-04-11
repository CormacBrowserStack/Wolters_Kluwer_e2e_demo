# Lloyds_bank_BS_demo

export BROWSERSTACK_CONFIG_FILE="./config/browserstack-single.yml" && npx percy exec -- mvn test -P sample-test
export BROWSERSTACK_CONFIG_FILE="./config/browserstack-parallel.yml" && mvn test -P sample-test