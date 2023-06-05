all: install-tools build-rust copy-wasm-to-public build-clojurescript serve

install-tools:
	cargo install wasm-pack --version 0.11.1; \
	cargo install miniserve --version 0.23.2

build-rust:
	cd rust-addition; \
	cargo update; \
	wasm-pack build --target web

copy-wasm-to-public:
	cp rust-addition/pkg/addition.js clojurescript-addition/public/wasm; \
	cp rust-addition/pkg/addition_bg.wasm clojurescript-addition/public/wasm; \

build-clojurescript:
	cd clojurescript-addition; \
	clojure -M -m cljs.main -co build.edn -c

serve:
	cd clojurescript-addition/public/; \
	miniserve . -p 12345 --index index.html