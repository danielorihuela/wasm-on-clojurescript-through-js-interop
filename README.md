# PoC

This repository is a proof of concept about the process of calling WASM code generated in Rust from ClojureScript through JavaScript interoperability.

## Tools

To run this project you need [Rust](https://www.rust-lang.org/tools/install) and [Clojure](https://clojure.org/guides/install_clojure).

I am using `clojure 1.10.2`, `rustup 1.26.0` (stable channel) and `rustc 1.70.0`.

## Run the project

This project includes a `makefile` that will automatically:

1. install some tools with specific versions
2. build wasm
3. copy wasm files to web site project
4. build web site
5. serve web site

You can run it executing:

```
make
```

## Limitation

I didn't found a way to serve the web site using ClojureScript. That means, that we cannot use the REPL.
If you try to do that, you will find the following problem:

> TypeError: WebAssembly: Response has unsupported MIME type 'text/html; charset=utf-8' expected 'application/wasm'

and 

> Uncaught CompileError: wasm validation error: at offset 4: failed to match magic number

If you search for the first error message you will find https://clojure.atlassian.net/browse/CLJS-3387. The problem seems to be solved, but Will Cohen complains that is still not working.

If you want to check that error. You have to move `out`, `wasm` and `index.html` from `clojurescript-addition/public` to `clojurescript-addition/`. Then run `clojure -M -m cljs.main -c addition.core --repl`.

## shadow cljs

Probably, you are going to build a web site using ClojureScript with a build tool. If you are goint so use [shadow cljs](https://github.com/thheller/shadow-cljs). I higly recommend that you take a look into a [demo using wasm with clojurescript from the shadow cljs creator](https://github.com/thheller/wasm-pack-cljs).
