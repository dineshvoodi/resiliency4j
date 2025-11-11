# Bulk Head
This is used to limit the number of concurrent calls to an API.

Assume ServiceA has five threads. Five concurrent requests for API-1 and 5 concurrent requests to API-2.

Then five requests to API-2 (which doesn't have any dependency on any service) will be blocked until API-1 completes the execution, because API-1 is dependent on ServiceB, which is slow.

To avoid this, we can limit max concurrent thread to API-1 to 2, so that API-2 can be processed quickly
* maxConcurrentCalls: 2 #maxConcurrentCalls: max number of concurrent calls allowed to service.
* maxWaitDuration: 0s #maxWaitDuration: any additional requests will wait for the given duration. Otherwise, it will go with default/fallback method.

# Circuit Breaker
Prevents an application from repeatedly trying to execute an operation that is likely to fail. It has three states: closed (normal), open (failing), and half-open (testing).
Closed: Initially, the circuit will be closed. Method calling API-B will work as usual. 
Open: If API-B is failing with set percentage out of max calls, the circuit will be in open state and fallback method is invoked. 
Half-open: After wait duration in open state completed, the circuit will be half-open. In this state few requests will be sent to actual service. If requests gets success, the circuit will be closed else open
* permittedNumberOfCallsInHalfOpenState: 2 #The number of requests allowed in the HALF-OPEN state.
* failureRateThreshold: 50 #Sets the percentage of failed calls required to open the circuit breaker
* minimumNumberOfCalls: 5 #Specifies the minimum number of calls before evaluating whether the circuit breaker should open.
* automaticTransitionFromOpenToHalfOpenEnabled: true #If true, the circuit breaker automatically transitions from open to half-open state after the wait duration.
* waitDurationInOpenState: 10s #Specifies how long the circuit breaker stays open before transitioning to half-open state.

# Rate Limiter
This is used to limit the rate, if API-B is invoked from a method more than set number of times in a given period, fallback is invoked.
* limitRefreshPeriod: 10s #Specifies the time window to count the requests.
* limitForPeriod: 2 #Specifies how many requests or method invocations are allowed in the above limitRefreshPeriod.


# Retry
If API-B is giving error. Method calling API-B will retry set number of times with delay. If service was not up after retries, call's fallback method.
* maxAttempts: 3 #Max retries if service failed, including the initial call plus retries
* waitDuration: 5s #Wait duration before each retry attempt

# Time Limiter
This is used to limit the time for API call. When API-B is called from a method, and if it is taking more time than a threshold. Fallback method is invoked.
* timeout-duration: 2s #No response within specified time, fallback method gets invoked