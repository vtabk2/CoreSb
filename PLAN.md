# Work plan: consolidate ad placement providers

Ngày bắt đầu: 2026-10-13
Ngày kết thúc: Chưa kết thúc — Auto test đang bị chặn bởi lỗi Gradle loopback.

## Tasks

- [completed] Vòng trước: thêm `AdSlot`, chuyển luồng khởi tạo/reinit sang cấu hình mới và migrate caller mẫu.
- [completed] Vòng trước: migrate toàn bộ override sang `adSlots`, xóa provider API legacy và cập nhật tài liệu.
- [completed] Code: mở rộng chính sách `preload` cho interstitial/rewarded để hỗ trợ lazy load placement không quan trọng.
- [completed] Viết test: kiểm tra default preload và opt-out của từng nhóm `AdSlot`.
- [in_progress] Auto test: chạy unit test baseui, compile module ảnh hưởng và kiểm tra diff.

## Scope

- Affected features: BaseActivity, BaseFragment, BaseAdsDialogFragment, BaseAdsBottomSheetDialogFragment, ContextAds, splash/onboarding/language/uninstall flows, demo ad screens, and the main host screen.
- Behavior to preserve: banner/native preload distinction, interstitial/reward grouping, `NativeInterstitial` staying in the interstitial group, and runtime reinitialization.
- Compatibility: legacy provider methods and constructor/reinit APIs are intentionally removed because this repository is being rewritten; default preload của interstitial/rewarded được giữ nguyên.

## Verification

- Focused JVM test for `AdSlot` grouping.
- `./gradlew.bat :core:baseui:testDevDebugUnitTest`
- `./gradlew.bat :core:baseui:compileDevDebugKotlin`
- `git diff --check`

## Test log

- `git diff --check`: passed.
- Legacy provider/reinit API scan: no remaining Kotlin/Java references; documentation was migrated to `adSlots`.
- Documentation update: bổ sung hướng dẫn khai báo `AdSlot`, phân nhóm preload/interstitial/rewarded và `reinitAdSlots` trong `docs/native-interstitial-config.md`.
- Previous auto-test blocker is retained below as environment history; this optimization starts a new Code → Test → Auto test cycle.
- `git diff --check`: passed.
- `:core:baseui:testDevDebugUnitTest`: blocked before task execution; Gradle still reports `java.io.IOException: Unable to establish loopback connection`.
- `:core:baseui:compileDevDebugKotlin`: blocked by the same environment issue.
- Static check: preload registry is cleared on `reinitAdSlots`/`onDestroy`; existing interstitial/rewarded callers retain default preload behavior.
- `:core:baseui:testDevDebugUnitTest`: blocked before task execution; Gradle reports `java.io.IOException: Unable to establish loopback connection`.
- `:core:baseui:compileDevDebugKotlin`, `:core:startflow:compileDevDebugKotlin`, `:app:compileDevDebugKotlin`: blocked by the same environment issue after supplying Android Studio JBR manually.
- Auto test remains `in_progress` until Gradle can start successfully.
- New rewrite cycle started on 2026-10-13; the previous Gradle loopback blocker remains to be rechecked after migration.
