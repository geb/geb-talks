## Grey box testing

*Black box* - no internal knowledge of or access to system.

*White box* - test via internals.

The Remote Control plugin enables _grey box_ testing, making internal verifications possible.

## Grey box example

You can use Remote Control + Greenmail plugins for testing email sending.

Greenmail is an in memory SMTP server that you can send mail to.

The Remote Control plugin lets you interrogate the server to see what it received.

# Demo

\#8 - Email

## When to use?

If you don't need to verify the external representation of the change, verify via internals.

Why?

1. More robust (UIs change more often than APIs)
2. More efficient (now browser involved)
3. Easier to debug/better diagnostics
4. No need for special UIs just to expose data

Familiarity with the `remote-control` plugin can save you pain in your tests.
