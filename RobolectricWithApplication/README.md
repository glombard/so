**[Question](http://stackoverflow.com/questions/28825317/):**
How do I correctly use `ActivityController.withApplication(new TestApp())` in an Android Studio 1.1 app using the new "experimental" [unit testing support](http://tools.android.com/tech-docs/unit-testing-support)?

Run the unit tests:

	$ ./gradlew :app:testDebug

This results in a NPE exception in the `usesMessageFromProvider` unit test at the point we `create()` the activity.

If I remove the `withApplication` bit, then the test runs OK (i.e. no exceptions) and correctly fails on the assert as I'd expect... So it's clearly the `withApplication` bit that's causing the problem.

Full stack trace:

	java.lang.RuntimeException: java.lang.reflect.InvocationTargetException
		at org.robolectric.internal.ReflectionHelpers.callStaticMethodReflectively(ReflectionHelpers.java:83)
		at org.robolectric.bytecode.ShadowWrangler$5.call(ShadowWrangler.java:247)
		at org.robolectric.bytecode.ShadowWrangler.intercept(ShadowWrangler.java:212)
		at org.robolectric.bytecode.RobolectricInternals.intercept(RobolectricInternals.java:53)
		at android.app.Activity.attach(Activity.java:5092)
		at org.robolectric.internal.ReflectionHelpers$3.run(ReflectionHelpers.java:64)
		at org.robolectric.internal.ReflectionHelpers.traverseClassHierarchy(ReflectionHelpers.java:114)
		at org.robolectric.internal.ReflectionHelpers.callInstanceMethodReflectively(ReflectionHelpers.java:59)
		at org.robolectric.util.ActivityController.attach(ActivityController.java:60)
		at org.robolectric.util.ActivityController$1.run(ActivityController.java:114)
		at org.robolectric.shadows.ShadowLooper.runPaused(ShadowLooper.java:268)
		at org.robolectric.util.ActivityController.create(ActivityController.java:111)
		at org.robolectric.util.ActivityController.create(ActivityController.java:122)
		at com.codeblast.robolectricwithapplication.MainActivityTest.usesMessageFromProvider(MainActivityTest.java:20)
		at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
		at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
		at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
		at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
		at org.robolectric.RobolectricTestRunner$2.evaluate(RobolectricTestRunner.java:236)
		at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
		at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
		at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
		at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
		at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
		at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
		at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
		at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
		at org.robolectric.RobolectricTestRunner$1.evaluate(RobolectricTestRunner.java:158)
		at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.runTestClass(JUnitTestClassExecuter.java:86)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.execute(JUnitTestClassExecuter.java:49)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassProcessor.processTestClass(JUnitTestClassProcessor.java:69)
		at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:48)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
		at org.gradle.messaging.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32)
		at org.gradle.messaging.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93)
		at com.sun.proxy.$Proxy2.processTestClass(Unknown Source)
		at org.gradle.api.internal.tasks.testing.worker.TestWorker.processTestClass(TestWorker.java:105)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
		at org.gradle.messaging.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:360)
		at org.gradle.internal.concurrent.DefaultExecutorFactory$StoppableExecutorImpl$1.run(DefaultExecutorFactory.java:64)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	Caused by: java.lang.reflect.InvocationTargetException
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.robolectric.internal.ReflectionHelpers.callStaticMethodReflectively(ReflectionHelpers.java:81)
		at org.robolectric.bytecode.ShadowWrangler$5.call(ShadowWrangler.java:247)
		at org.robolectric.bytecode.ShadowWrangler.intercept(ShadowWrangler.java:212)
		at org.robolectric.bytecode.RobolectricInternals.intercept(RobolectricInternals.java:53)
		at android.app.Activity.$$robo$$Activity_c57b_attach(Activity.java:5092)
		at android.app.Activity.attach(Activity.java)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.robolectric.internal.ReflectionHelpers$3.run(ReflectionHelpers.java:64)
		at org.robolectric.internal.ReflectionHelpers.traverseClassHierarchy(ReflectionHelpers.java:114)
		at org.robolectric.internal.ReflectionHelpers.callInstanceMethodReflectively(ReflectionHelpers.java:59)
		at org.robolectric.util.ActivityController.attach(ActivityController.java:60)
		at org.robolectric.util.ActivityController$1.run(ActivityController.java:114)
		at org.robolectric.shadows.ShadowLooper.runPaused(ShadowLooper.java:268)
		at org.robolectric.util.ActivityController.create(ActivityController.java:111)
		at org.robolectric.util.ActivityController.create(ActivityController.java:122)
		at com.codeblast.robolectricwithapplication.MainActivityTest.usesMessageFromProvider(MainActivityTest.java:20)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
		at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
		at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
		at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
		at org.robolectric.RobolectricTestRunner$2.evaluate(RobolectricTestRunner.java:236)
		at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
		at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
		at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
		at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
		at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
		at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
		at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
		at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
		at org.robolectric.RobolectricTestRunner$1.evaluate(RobolectricTestRunner.java:158)
		at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.runTestClass(JUnitTestClassExecuter.java:86)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.execute(JUnitTestClassExecuter.java:49)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassProcessor.processTestClass(JUnitTestClassProcessor.java:69)
		at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:48)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
		at org.gradle.messaging.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32)
		at org.gradle.messaging.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93)
		at com.sun.proxy.$Proxy2.processTestClass(Unknown Source)
		at org.gradle.api.internal.tasks.testing.worker.TestWorker.processTestClass(TestWorker.java:105)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		... 7 more
	Caused by: java.lang.reflect.InvocationTargetException
		at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
		at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)
		at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
		at java.lang.reflect.Constructor.newInstance(Constructor.java:526)
		at org.robolectric.shadows.ShadowWindow.create(ShadowWindow.java:34)
		... 67 more
	Caused by: java.lang.NullPointerException
		at android.content.ContextWrapper.getSystemService(ContextWrapper.java:519)
		at android.view.LayoutInflater.from(LayoutInflater.java:211)
		at android.view.ContextThemeWrapper.getSystemService(ContextThemeWrapper.java:113)
		at android.app.Activity.getSystemService(Activity.java:4502)
		at android.view.LayoutInflater.from(LayoutInflater.java:211)
		at com.android.internal.policy.impl.PhoneWindow.__constructor__(PhoneWindow.java:215)
		at com.android.internal.policy.impl.PhoneWindow.<init>(PhoneWindow.java:214)
		at org.robolectric.shadows.ShadowWindow.create(ShadowWindow.java:34)
		at org.robolectric.internal.ReflectionHelpers.callStaticMethodReflectively(ReflectionHelpers.java:81)
		at org.robolectric.bytecode.ShadowWrangler$5.call(ShadowWrangler.java:247)
		at org.robolectric.bytecode.ShadowWrangler.intercept(ShadowWrangler.java:212)
		at org.robolectric.bytecode.RobolectricInternals.intercept(RobolectricInternals.java:53)
		at android.app.Activity.attach(Activity.java:5092)
		at org.robolectric.internal.ReflectionHelpers$3.run(ReflectionHelpers.java:64)
		at org.robolectric.internal.ReflectionHelpers.traverseClassHierarchy(ReflectionHelpers.java:114)
		at org.robolectric.internal.ReflectionHelpers.callInstanceMethodReflectively(ReflectionHelpers.java:59)
		at org.robolectric.util.ActivityController.attach(ActivityController.java:60)
		at org.robolectric.util.ActivityController$1.run(ActivityController.java:114)
		at org.robolectric.shadows.ShadowLooper.runPaused(ShadowLooper.java:268)
		at org.robolectric.util.ActivityController.create(ActivityController.java:111)
		at org.robolectric.util.ActivityController.create(ActivityController.java:122)
		at com.codeblast.robolectricwithapplication.MainActivityTest.usesMessageFromProvider(MainActivityTest.java:20)
		at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
		at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
		at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
		at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
		at org.robolectric.RobolectricTestRunner$2.evaluate(RobolectricTestRunner.java:236)
		at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
		at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
		at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
		at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
		at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
		at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
		at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
		at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
		at org.robolectric.RobolectricTestRunner$1.evaluate(RobolectricTestRunner.java:158)
		at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.runTestClass(JUnitTestClassExecuter.java:86)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.execute(JUnitTestClassExecuter.java:49)
		at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassProcessor.processTestClass(JUnitTestClassProcessor.java:69)
		at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:48)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
		at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
		at org.gradle.messaging.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32)
		at org.gradle.messaging.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93)
		at com.sun.proxy.$Proxy2.processTestClass(Unknown Source)
		at org.gradle.api.internal.tasks.testing.worker.TestWorker.processTestClass(TestWorker.java:105)
		... 7 more

It seems like when it's doing the `LayoutInflater.from` call, the Context is null, but why - what am I doing wrong?
