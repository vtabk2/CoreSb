# Work plan: consolidate ad placement providers

Ngày bắt đầu: 2026-10-13
Ngày kết thúc: Chưa kết thúc — Auto test đang bị chặn bởi lỗi Gradle loopback.

## Tasks

- [completed] Vòng trước: thêm `AdSlot`, chuyển luồng khởi tạo/reinit sang cấu hình mới và migrate caller mẫu.
- [completed] Code: migrate toàn bộ override còn lại sang `adSlots`; xóa provider API legacy và compatibility bridge vì repository đang được viết lại.
- [completed] Viết test: cập nhật unit test cho contract nhóm placement và cờ preload sau khi bỏ API cũ.
- [in_progress] Auto test: chạy test hẹp, compile các module bị ảnh hưởng và kiểm tra diff.

## Scope

- Affected features: BaseActivity, BaseFragment, BaseAdsDialogFragment, BaseAdsBottomSheetDialogFragment, ContextAds, splash/onboarding/language/uninstall flows, demo ad screens, and the main host screen.
- Behavior to preserve: banner/native preload distinction, interstitial/reward grouping, `NativeInterstitial` staying in the interstitial group, and runtime reinitialization.
- Compatibility: legacy provider methods and constructor/reinit APIs are intentionally removed because this repository is being rewritten.

## Verification

- Focused JVM test for `AdSlot` grouping.
- `./gradlew.bat :core:baseui:testDevDebugUnitTest`
- `./gradlew.bat :core:baseui:compileDevDebugKotlin`
- `git diff --check`

## Test log

- `git diff --check`: passed.
- Legacy provider/reinit API scan: no remaining Kotlin/Java references; documentation was migrated to `adSlots`.
- Documentation update: bổ sung hướng dẫn khai báo `AdSlot`, phân nhóm preload/interstitial/rewarded và `reinitAdSlots` trong `docs/native-interstitial-config.md`.
- `:core:baseui:testDevDebugUnitTest`: blocked before task execution; Gradle reports `java.io.IOException: Unable to establish loopback connection`.
- `:core:baseui:compileDevDebugKotlin`, `:core:startflow:compileDevDebugKotlin`, `:app:compileDevDebugKotlin`: blocked by the same environment issue after supplying Android Studio JBR manually.
- Auto test remains `in_progress` until Gradle can start successfully.
- New rewrite cycle started on 2026-10-13; the previous Gradle loopback blocker remains to be rechecked after migration.
