# Suspend in JobIntentService
Experimental project created to compare running coroutine in JobIntentService via GlobalScope.launch and runBlocking.

# Result:
I found out that if I start the coroutine through GlobalScope.launch, the service will be immediately destroyed, although the coroutine will continue to execute for a little time (I had 94 seconds).

If you start a coroutine through runBlocking, the service will run until you finish the coroutine. My service with runBlocking worked for 624 seconds and then was frozen by the system until the application was opened.

